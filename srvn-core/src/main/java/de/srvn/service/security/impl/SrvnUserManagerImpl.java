package de.srvn.service.security.impl;

import de.srvn.service.security.SrvnUserManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * @author <a href="mailto:moormann@pondus.de">Markus Moormann </a>
 */
public class SrvnUserManagerImpl implements SrvnUserManager {
    @Override
    public List<String> findAllGroups() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<String> findUsersInGroup(String groupName) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void createGroup(String groupName, List<GrantedAuthority> authorities) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void deleteGroup(String groupName) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void renameGroup(String oldName, String newName) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void addUserToGroup(String username, String group) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void removeUserFromGroup(String username, String groupName) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<GrantedAuthority> findGroupAuthorities(String groupName) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void addGroupAuthority(String groupName, GrantedAuthority authority) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void removeGroupAuthority(String groupName, GrantedAuthority authority) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void createUser(UserDetails user) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void updateUser(UserDetails user) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void deleteUser(String username) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean userExists(String username) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
