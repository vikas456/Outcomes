package com.apps.vikasperaka.outcomes;

import java.io.Serializable;

/**
 * Created by vikasperaka on 8/15/17.
 */

/*
    Areas for expansion: minimum punishments, overseeing court, type of punishment, effects on future
 */

public class Crime implements Serializable{
    //made serializable in order to pass the class through intents

    //instances for fine and prison term
    private String crime;
    private int fine;
    private int years;

    /**
     * Default constructor
     */
    public Crime() {
        crime = "";
        fine = 0;
        years = 0;
    }

    /**
     * Constructor passed through with crime information
     * @param crime the name of the crime
     * @param years the number of years of imprisonment for the crime
     * @param fine the fine for the crime
     */
    public Crime(String crime, int years, int fine){
        this.crime = crime;
        this.fine = fine;
        this.years = years;
    }

    /**
     * Accesses the fine total
     * @return the fine
     */
    public int getFine(){
        return fine;
    }

    /**
     * Accesses the number of years of imprisonment
     * @return the number of years of imprisonment
     */
    public int getTerm(){
        return years;
    }

    /**
     * Accesses the name of the crime
     * @return the name of the crime
     */
    public String getCrime(){
        return crime;
    }

    /**
     * Formats the punishment in a string with years first followed by the fine.
     * @return the punishment string
     */
    public String getPunishmnet(){
        return years + " years, $" + fine;
    }
}
