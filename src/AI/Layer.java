package AI;

import java.util.function.Function;

public class Layer {
    public int inputWidth;
    private int width;
    private Function<Double, Double> activation;
    private double[][] weights;
    private double[] biases;

    public Layer(int width, double[][] weights, double[] biases) {
        this.biases=biases;
        this.weights= weights;
        this.width = width;
        //Relu activation function
        this.activation = x ->{if (x < 0) return 0.; else return x;};
    }

    public Layer(int width) {
        this.weights=randomWeights(inputWidth,width);
        this.width = width;
        //Relu activation function
        this.activation = x ->{if (x < 0) return 0.; else return x;};
    }

    public double[][] randomWeights(int inputWidth, int width) {
        double[][] weights = new double[width][inputWidth];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < inputWidth; j++) {
                weights[i][j] = Math.random()-0.5;
            }
        }
        return weights;
    }

    public int getWidth() {
        return width;
    }

    public double[] calculateOutputs(double[] input) {
        double[] output = new double[width];
        for (int i = 0; i < width; i++) {
            double sum = 0;
            for (int j = 0; j < input.length; j++) {
                sum += input[j] * weights[i][j];
            }
            output[i] = activation.apply(sum + biases[i]);
        }
        return output;
    }

    public Layer mutate(double rate) {
        double[][] newWeights = new double[width][inputWidth];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < inputWidth; j++) {
                if (Math.random() < rate) {
                    newWeights[i][j] = Math.random()-0.5;
                } else {
                    newWeights[i][j] = weights[i][j];
                }
            }
        }
        double[] newBiases = new double[width];
        for (int i = 0; i < width; i++) {
            if (Math.random() < rate) {
                newBiases[i] = Math.random()-0.5;
            } else {
                newBiases[i] = biases[i];
            }
        }
        return new Layer(width, newWeights, newBiases);
    }

}
