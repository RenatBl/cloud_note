package ru.itis.program.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.program.models.User;
import ru.itis.program.repo.UsersRepo;

import java.util.Optional;


@Service(value = "customUserDetailsService")
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UsersRepo usersRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userCandidate = usersRepo.findByUsername(username);

        if (userCandidate.isPresent()) {
            return new UserDetailsImpl(userCandidate.get());
        }
        throw new UsernameNotFoundException("User not found");
    }
}
