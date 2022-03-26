package AI;

import java.util.Arrays;

public class Generation {
    private int generationSize=100;
    private int maxGeneration=3;
    private int currentGeneration=0;
    public AI_Bot[] population= new AI_Bot[generationSize];
    private double mutationRate=0.05;

    //first gen initializes the population
    public Generation(){
        for(int i=0;i<generationSize;i++){
            population[i]=new AI_Bot();
        }
    }
    //manual constructor
    public Generation(AI_Bot[] population){
        this.population=population;
    }

    //following generations are based on the previous generation
    public Generation(Generation g){
        Arrays.sort(g.population,(AI_Bot a, AI_Bot b)-> a.fitness-b.fitness);
        AI_Bot[] newPop=new AI_Bot[generationSize];
        for(int i=0;i<5;i++){
            AI_Bot[] newPopPart = g.population[i].breed(mutationRate);
            for (int j = 0; j < newPopPart.length; j++) {
                newPop[i* newPopPart.length+j]=newPopPart[j];
            }
        }
        this.population=newPop;
        currentGeneration++;
    }



}
