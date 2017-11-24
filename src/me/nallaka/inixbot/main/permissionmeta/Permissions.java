package me.nallaka.inixbot.main.permissionmeta;

import me.nallaka.inixbot.main.commandmeta.Command;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Permissions extends ListenerAdapter {
    private static Map<User, PermissionLevel> userPermissionLevelMap = new Map<User, PermissionLevel>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean containsKey(Object key) {
            return false;
        }

        @Override
        public boolean containsValue(Object value) {
            return false;
        }

        @Override
        public PermissionLevel get(Object key) {
            return null;
        }

        @Override
        public PermissionLevel put(User key, PermissionLevel value) {
            return null;
        }

        @Override
        public PermissionLevel remove(Object key) {
            return null;
        }

        @Override
        public void putAll(Map<? extends User, ? extends PermissionLevel> m) {

        }

        @Override
        public void clear() {

        }

        @Override
        public Set<User> keySet() {
            return null;
        }

        @Override
        public Collection<PermissionLevel> values() {
            return null;
        }

        @Override
        public Set<Entry<User, PermissionLevel>> entrySet() {
            return null;
        }
    };

    public void setDefaultUserPermissions(JDA jda) {
        List<User> userList = jda.getUsers();
        for (User u : userList) {
            userPermissionLevelMap.put(u, PermissionLevel.LOW);
        }
    }

    //TODO: Get user permissions from file and put in map
    public void loadUserPermissionLevels() {

    }

    public void setUserPermissionLevel(User user, PermissionLevel permissionLevel) {
        if (!userPermissionLevelMap.containsKey(user)) {
            userPermissionLevelMap.put(user, permissionLevel);
        }
    }

    public void changeUserPermissionLevel(User user, PermissionLevel permissionLevel) {
        userPermissionLevelMap.remove(user);
        userPermissionLevelMap.put(user, permissionLevel);
    }

    public boolean userHasPermissionLevel(User user, PermissionLevel permissionLevel) {
        return  (userPermissionLevelMap.get(user).equals(permissionLevel));
    }

    public boolean userHasCommandPermission(User user, Command command) {
        return (userPermissionLevelMap.get(user).equals(command.getCommandPermissionLevel()));
    }


}
