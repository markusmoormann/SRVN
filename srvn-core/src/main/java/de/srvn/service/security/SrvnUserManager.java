package de.srvn.service.security;

import org.springframework.security.provisioning.GroupManager;
import org.springframework.security.provisioning.UserDetailsManager;

/**
 * @author <a href="mailto:moormann@pondus.de">Markus Moormann </a>
 */
public interface SrvnUserManager extends UserDetailsManager, GroupManager {
}
