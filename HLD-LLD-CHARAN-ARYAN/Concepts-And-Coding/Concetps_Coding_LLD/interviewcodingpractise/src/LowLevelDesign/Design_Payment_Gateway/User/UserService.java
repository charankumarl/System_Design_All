package LowLevelDesign.Design_Payment_Gateway.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    List<User> userList = new ArrayList<>();

    public UserDo addUser(UserDo userDo){

        User user = new User();

        user.setId(userDo.getUserId());
        user.setName(userDo.getName());
        user.setEmail(userDo.getEmail());
        user.setPhone(userDo.getPhone());

        userList.add(user);

        return userDo;
    }

    public UserDo getUserById(int id){

        for(User user : userList){
            if(user.getId() == id){

                return convertUserToUserDo(user);
            }
        }
        return null;
    }

    public UserDo convertUserToUserDo(User user){

        UserDo userDo = new UserDo();
        userDo.setUserId(user.getId());
        userDo.setName(user.getName());
        userDo.setEmail(user.getEmail());
        userDo.setPhone(user.getPhone());
        return userDo;
    }
}
