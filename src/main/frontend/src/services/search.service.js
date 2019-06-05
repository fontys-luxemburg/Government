export const searchService = {
  search
};

function search(query) {
  return fetch(`/government/api/search?query=${encodeURI(query)}`)
      .then(handleResponse)
      .then(searchResults => {
        return searchResults;
      })
}

function handleResponse(response) {
  const data = response.json();

  if (!response.ok) {
    if (response.status === 401) {
      userService.logout();
    }

    const error = (data && data.message) || response.statusText;
    return Promise.reject(error);
  }

  return data;
}