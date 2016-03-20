package neural;

import utils.MathUtils;

import java.util.ArrayList;

public class Neuron {

    private static final int BIAS = 1;
    private static final double LEARNING_RATIO = 0.1;

    private ArrayList<Integer> inputs;
    private ArrayList<Double> weights;
    private double biasWeight;
    private double output;

    public Neuron() {
        this.inputs = new ArrayList<>();
        this.weights = new ArrayList<>();
        this.biasWeight = Math.random();
    }

    public void setInputs(ArrayList<Integer> inputs) {
        if (this.inputs.size() == 0) {
            this.inputs = new ArrayList<>(inputs);
            generateWeights();
        }

        this.inputs = new ArrayList<>(inputs);
    }

    private void generateWeights() {
        for (int i = 0; i < inputs.size(); i++) {
            weights.add(Math.random());
        }
    }

    public void calculateOutput() {
        double sum = 0;

        for (int i = 0; i < inputs.size(); i++) {
            sum += inputs.get(i) * weights.get(i);
        }
        sum += BIAS * biasWeight;

        output = MathUtils.sigmoidValue(sum);
    }

    public void adjustWeights(double delta) {
        for (int i = 0; i < inputs.size(); i++) {
            double d = weights.get(i);
            d += LEARNING_RATIO * delta * inputs.get(i);
            weights.set(i, d);
        }

        biasWeight += LEARNING_RATIO * delta * BIAS;
    }

    public double getOutput() {
        calculateOutput();

        return output;
    }

}
