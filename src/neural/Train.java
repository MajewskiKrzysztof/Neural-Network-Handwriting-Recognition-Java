package neural;

import data.ReadWriteFile;

import java.util.ArrayList;

public class Train {

    private static final int NEURON_COUNT = 26;

    private Network network;
    private ArrayList<TrainingSet> trainingSets;

    public Train() {
        this.network = new Network();
        this.network.addNeurons(NEURON_COUNT);
        this.trainingSets = ReadWriteFile.readTrainingSets();
    }

    public void train(long count) {
        for (long i = 0; i < count; i++) {
            int index = ((int) (Math.random() * trainingSets.size()));
            TrainingSet set = trainingSets.get(index);
            network.setInputs(set.getInputs());
            network.adjustWages(set.getGoodOutput());
        }
    }

    public void setInputs(ArrayList<Integer> inputs) {
        network.setInputs(inputs);
    }

    public void addTrainingSet(TrainingSet newSet) {
        trainingSets.add(newSet);
    }

    public ArrayList<Double> getOutputs() {
        return network.getOutputs();
    }

}
