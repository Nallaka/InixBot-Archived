package me.nallaka.inixbot.main.permissionmeta;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlWriter;
import me.nallaka.inixbot.main.commandmeta.Command;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    private String filePath = "me/nallaka/inixbot/main/permissionmeta/permissions.properties";
    private YamlReader yamlReader = new YamlReader(new FileReader("permissions.yml"));
    private YamlWriter yamlWriter = new YamlWriter(new FileWriter("permissions.yml"));


    public Permissions() throws IOException {
    }

    public void loadUsersPermissionLevels() {
        try {
            userPermissionLevelMap = (Map<String, PermissionLevel>) yamlReader.read();
        } catch (YamlException e) {
            e.printStackTrace();
        }
    }

    public void setUserDefaultPermissionLevel(User user) {
        if (!userPermissionLevelMap.containsKey(user.getId())) {
            userPermissionLevelMap.put(user.getId(), PermissionLevel.DEFAULT);
        }
        updateYaml();

    }

    public void setUsersDefaultPermissionLevels(JDA jda) {
        List<User> userList = jda.getUsers();
        for (User u : userList) {
            userPermissionLevelMap.put(u.getId(), PermissionLevel.LOW);
        }
        updateYaml();
    }

    public void changeUserPermissionLevel(User user, PermissionLevel permissionLevel) {
        userPermissionLevelMap.remove(user.getId());
        userPermissionLevelMap.put(user.getId(), permissionLevel);
        updateYaml();
    }

    public boolean userHasPermissionLevel(User user, PermissionLevel permissionLevel) {
        return  (userPermissionLevelMap.get(user.getId()).equals(permissionLevel));
    }

    public boolean userHasCommandPermission(User user, Command command) {
        return userPermissionLevelMap.get(user.getId()).ordinal() >= command.getCommandPermissionLevel().ordinal();
    }

    //Test

    public void updateYaml() {
        try {
            yamlWriter.write(userPermissionLevelMap);
            yamlWriter.close();
        } catch (YamlException e) {
            e.printStackTrace();
        }
    }
}
