package me.nallaka.inixbot.main.permissionmeta;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.List;
import java.util.Map;

public class Permissions extends ListenerAdapter {
    static Map<User, PermissionLevel> userPermissionLevelMap;

    public void setDefaultUserPermissions(JDA jda) {
        List<User> userList = jda.getUsers();
        for (User u : userList) {
            userPermissionLevelMap.put(u, PermissionLevel.LOW);
        }
    }

    //TODO: Get user permissions from file and put in map
    //TODO: Add method to change user permission


}
