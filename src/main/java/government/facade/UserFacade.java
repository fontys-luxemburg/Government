package government.facade;

import government.dto.UserDto;
import government.mapper.UserMapper;
import government.model.Ownership;
import government.model.User;
import government.repository.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class UserFacade implements BaseFacade<User, Long> {

    @Inject
    UserRepository userRepository;

    @Inject
    UserMapper userMapper;

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    public List<UserDto> search(String searchTerm) {
        return userMapper.usersToUsersDtos(userRepository.search(searchTerm));
    }

    @Override
    public User save(User entity) {
        try {
            entity.setPassword(encodeSHA256(entity.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        userRepository.save(entity);
        return entity;
    }

    public static String encodeSHA256(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hash);
    }
}
