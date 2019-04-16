import { authHeader } from "../helpers";

export const userService = {
    login,
    logout,
}

function login(email, password) {
    const requestOptions= {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ email, password })
    };

    return fetch('/government/api/authentication', requestOptions)
        .then(handleResponse)
        .then(user => {
            if (user.token) {
                localStorage.setItem('user', JSON.stringify(user));
            }

            return user;
        });
}

function logout() {
    localStorage.removeItem('user');
}

function handleResponse(response) {
    const data = response.json();

    if(!response.ok) {
        if(response.status === 401) {
            logout();
        }

        const error = (data && data.message) || response.statusText;
        return Promise.reject(error);
    }

    return data;
}