package me.nallaka.inixbot.main.permissionmeta;

import me.nallaka.inixbot.main.commandmeta.Command;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

public class Permissions extends ListenerAdapter {
    private static Map<String, PermissionLevel> userPermissionLevelMap = new Map<String, PermissionLevel>() {
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
        public PermissionLevel put(String key, PermissionLevel value) {
            return null;
        }

        @Override
        public PermissionLevel remove(Object key) {
            return null;
        }

        @Override
        public void putAll(Map<? extends String, ? extends PermissionLevel> m) {

        }

        @Override
        public void clear() {

        }

        @Override
        public Set<String> keySet() {
            return null;
        }

        @Override
        public Collection<PermissionLevel> values() {
            return null;
        }

        @Override
        public Set<Entry<String, PermissionLevel>> entrySet() {
            return null;
        }

        @Override
        public boolean equals(Object o) {
            return false;
        }

        @Override
        public int hashCode() {
            return 0;
        }
    };
    Properties properties = new Properties();
    InputStream input = null;
    OutputStream output = null;
    String filePath = "me/nallaka/inixbot/main/permissionmeta/permissions.properties";

    public void loadUsersPermissionLevels() {
        try {
            input = getClass().getClassLoader().getResourceAsStream(filePath);
            if (input == null) {
                System.out.println("Sorry, unable to find " + filePath);
                return;
            }

            properties.load(input);

            Enumeration<?> e = properties.propertyNames();
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                String value = properties.getProperty(key);
                PermissionLevel permissionLevel;
                switch (value) {
                    case "DEFAULT":
                        permissionLevel = PermissionLevel.DEFAULT;
                        break;
                    case "LOW":
                        permissionLevel = PermissionLevel.LOW;
                        break;
                    case "MEDIUM":
                        permissionLevel = PermissionLevel.MEDIUM;
                        break;
                    case "HIGH":
                        permissionLevel = PermissionLevel.HIGH;
                        break;
                    case "ADMIN":
                        permissionLevel = PermissionLevel.ADMIN;
                        break;
                    case "OWNER":
                        permissionLevel = PermissionLevel.OWNER;
                        break;
                    default:
                        permissionLevel = PermissionLevel.DEFAULT;
                        break;
                }
                userPermissionLevelMap.put(key, permissionLevel);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void setUserDefaultPermissionLevel(User user) {
        if (!userPermissionLevelMap.containsKey(user.getId())) {
            userPermissionLevelMap.put(user.getId(), PermissionLevel.DEFAULT);
        }
    }

    public void setUsersDefaultPermissionLevels(JDA jda) throws FileNotFoundException {

    }

    public void changeUserPermissionLevel(User user, PermissionLevel permissionLevel) {
        userPermissionLevelMap.remove(user.getId());
        userPermissionLevelMap.put(user.getId(), permissionLevel);
    }

    public boolean userHasPermissionLevel(User user, PermissionLevel permissionLevel) {
        return  (userPermissionLevelMap.get(user.getId()).equals(permissionLevel));
    }

    public boolean userHasCommandPermission(User user, Command command) {
        return userPermissionLevelMap.get(user.getId()).ordinal() >= command.getCommandPermissionLevel().ordinal();
    }


}
