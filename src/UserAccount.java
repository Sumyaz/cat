import java.util.ArrayList;
public class UserAccount {
private ArrayList<ArrayList<Cat>> userCats;
public UserAccount() {

    userCats = new ArrayList<>();
}
public void addCat(ArrayList<Cat> cats) {
    userCats.add(cats);
}
public ArrayList<ArrayList<Cat>> getAllCats() {
    return userCats;
}
}