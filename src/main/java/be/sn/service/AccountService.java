package be.sn.service;

import be.sn.entities.AppRole;
import be.sn.entities.AppUser;

public interface AccountService {
    public AppUser saveUser(AppUser user);

    public AppRole saveRole(AppRole role);

    public void addRoleToUse(String username, String roleName);

    public AppUser findUserByUsername(String username);
}
