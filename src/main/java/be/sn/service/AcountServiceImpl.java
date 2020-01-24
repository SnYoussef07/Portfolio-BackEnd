package be.sn.service;

import be.sn.dao.RoleRepository;
import be.sn.dao.UserRepository;
import be.sn.entities.AppRole;
import be.sn.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AcountServiceImpl implements AccountService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public AppUser saveUser(AppUser user) {
        String hashPW = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashPW);
        return userRepository.save(user);
    }

    @Override
    public AppRole saveRole(AppRole role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUse(String username, String roleName) {
        AppRole role = roleRepository.findByRoleName(roleName);
        if (role == null) throw new RuntimeException("Role is null");
        AppUser user = userRepository.findByUsername(username);
        //puisqu y'a transactional , lors du commit il l'aouje dans la db
        user.getAppRoles().add(role);
    }

    @Override
    public AppUser findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
