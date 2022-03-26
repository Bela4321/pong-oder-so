package AI;

import java.util.Arrays;

public class NeuralNet {
    private int inputWidth;
    private boolean[] outputs;
    private Layer[] layers;

    public NeuralNet( int[] layerWidths) {
        inputWidth = layerWidths[0];
        for (int i = 0; i < layerWidths.length; i++) {
            layers[i] = new Layer(layerWidths[i]);
        }
    }
    public NeuralNet(Layer[] layers) {
        this.layers = layers;
        inputWidth = layers[0].inputWidth;
        outputs = new boolean[layers[layers.length - 1].getWidth()];
    }

    public void calculateOutputs(double[] input) {
        for (int i = 0; i< layers.length; i++) {
            input = layers[i].calculateOutputs(input);
        }
        for (int i = 0; i < outputs.length; i++) {
            if (input[i] > 0.5) {
                outputs[i] = true;
            } else {
                outputs[i] = false;
            }
        }
    }
    public NeuralNet mutate(double mutationRate) {
        Layer[] newLayers = Arrays.copyOf(layers, layers.length);
        for (int i = 0; i < newLayers.length; i++) {
            newLayers[i].mutate(mutationRate);
        }
        return new NeuralNet(newLayers);
    }
    public boolean[] getOutputs() {
        return outputs;
    }
}
