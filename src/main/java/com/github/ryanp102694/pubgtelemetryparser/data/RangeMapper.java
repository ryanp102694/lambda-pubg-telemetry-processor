package com.github.ryanp102694.pubgtelemetryparser.data;

import org.springframework.stereotype.Component;

import java.util.function.Function;

//Spring Cloud tries to make a bean out of this class because it implements the interface it looks for while creating Lambda entry points
@Component("leaveMeAlone")
public class RangeMapper implements Function<Double, Double> {

    private double inputLowerBound;
    private double inputUpperBound;
    private double outputLowerBound;
    private double outputUpperBound;

    public RangeMapper() {}

    public RangeMapper(double inputLowerBound, double inputUpperBound){
        this(inputLowerBound, inputUpperBound, 0.0, 1.0);
    }

    public RangeMapper(double inputLowerBound, double inputUpperBound, double outputLowerBound, double outputUpperBound){
        this.inputLowerBound= inputLowerBound;
        this.inputUpperBound = inputUpperBound;
        this.outputLowerBound = outputLowerBound;
        this.outputUpperBound = outputUpperBound;
    }


    @Override
    public Double apply(Double input) {
        return ((input - inputLowerBound) * ((outputUpperBound - outputLowerBound)/(inputUpperBound - inputLowerBound))) + outputLowerBound;
    }
}
