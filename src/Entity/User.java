package Entity;

import java.util.ArrayList;

public class User {

    private static int idCounter = 1; // shared counter to generate ids for users

    private Integer userId; //auto-increment on every new instance
    private String name;
    private Role role = Role.VIEWER; // default role
    private Integer noOfReviewsGiven;


    public User(String name) {
        this.name = name;
        this.userId = idCounter++;
        this.noOfReviewsGiven = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getNoOfReviewsGiven() {
        return noOfReviewsGiven;
    }

    public void review(){
        this.noOfReviewsGiven++;
        switch (noOfReviewsGiven){
            case 3 :
                this.role = Role.CRITIC;
                printCurrentRole();
                break;
            case 5:
                this.role = Role.EXPERT;
                printCurrentRole();
                break;
            case 10:
                this.role = Role.ADMIN;
                printCurrentRole();
                break;
            default:
        }
    }

    private void printCurrentRole(){
        System.out.println("User " + this.name + " upgraded to " + this.role.toString());
    }


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", noOfReviewsGiven=" + noOfReviewsGiven +
                '}';
    }
}
