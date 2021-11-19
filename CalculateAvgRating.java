package com.company;

public class CalculateAvgRating {
    public double CalcAvgRating(Driver d){
        double sum=0;
        for(int i=0;i<d.getRatings().size();i++){
            sum+=d.getRatings().get(i).getStars();
        }
        return sum/d.getRatings().size();
    }
}
