package AI;

public class AI_Bot {
    private int generation;
    private NeuralNet brain;
    public int fitness;
    private int[] brainTopology= {12,15,10,7};
    private int offspringSize=20;

    public AI_Bot(){
        generation=0;
        brain = new NeuralNet(brainTopology);
    }

    public AI_Bot(AI_Bot parent, double mutationRate){
        this.brain=parent.brain.mutate(mutationRate);
        this.generation=parent.generation+1;
    }

    public AI_Bot[] breed(double mutateRate){
        AI_Bot[] children = new AI_Bot[offspringSize];
        for(int i=0;i<offspringSize-1;i++){
            children[i]=new AI_Bot(this,mutateRate);
        }
        children[offspringSize-1]=this;
        return children;
    }

    public boolean[] play(double[] inputs){
        brain.calculateOutputs(inputs);
        return brain.getOutputs();
    }
}
