package org.example;

public enum InfoMassage {
    CHOOSE_POSITION("Enter box number to select. Enjoy!\n"),
    MASSAGE_FROM_WINNER("You won the game!\nCreated by Shreyas Saha. Thanks for playing!"),
    MASSAGE_FROM_LOSER("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!"),
    MASSAGE_FROM_DRAW("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!"),
    MASSAGE_FROM_SECOND_CHOOSE_POSITION("That one is already in use. Enter another."),
    MASSAGE_FROM_CHOOSE_INVALID_POSITION("Invalid input. Enter again.");

    private final String informationMassage;

    InfoMassage(String informationMassage){
        this.informationMassage = informationMassage;
    }

    public String getInformationMassage(){
        return informationMassage;
    }
}

