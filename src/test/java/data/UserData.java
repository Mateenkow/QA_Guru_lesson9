package data;

import utils.FakerUserData;

/**
 * @author mateenkov
 */

public class UserData {
    FakerUserData fud = new FakerUserData();
    public String name = fud.getName();
    public String lastName = fud.getLastName();
    public String gender = fud.getGender();
    public String email = fud.getEmail();
    public String phone = fud.getPhone();
    public String day = fud.getDay();
    public String month = fud.getMonth();
    public String year = fud.getYear();
    public String subjects = fud.getSubjects();
    public String hobbies = fud.getHobbies();
    public String files = fud.getFiles();
    public String address = fud.getAddress();
    public String state = fud.getState();
    public String city = fud.getCity(state);
}
