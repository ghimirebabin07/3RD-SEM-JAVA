import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SwingWorkerDemo {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame("SwingWorker Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            JProgressBar progress = new JProgressBar(0, 100);
            progress.setStringPainted(true);
            JButton start = new JButton("Start Task");

            start.addActionListener((ActionEvent e) -> {
                start.setEnabled(false);
               
                SwingWorker<Void, Integer> worker = new SwingWorker<>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        for (int i = 0; i <= 100; i++) {
                            Thread.sleep(30);      // simulate work
                            publish(i);           // send intermediate results
                            setProgress(i);       // optional, updates getProgress()
                        }
                        return null;
                    }

                    @Override
                    protected void process(java.util.List<Integer> chunks) {
                        // runs on EDT: update UI with latest published value
                        int val = chunks.get(chunks.size() - 1);
                        progress.setValue(val);
                    }

                    @Override
                    protected void done() {
                        start.setEnabled(true);
                        JOptionPane.showMessageDialog(frame, "Task finished");
                    }
                };
                worker.execute();
            });

            frame.add(progress, BorderLayout.NORTH);
            frame.add(start, BorderLayout.CENTER);
            frame.setSize(300, 120);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
