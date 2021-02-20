package Part1;

import java.awt.*;
import java.util.Objects;
import javax.swing.*;

/**
 * create a user interface and calculate solution
 */
public class Application extends javax.swing.JFrame {
    private double[][] coeffs; //matrix of coefficients
    private double[] solution; //matrix of RHS of equations
    private int column; //column number equals coeffs.len + 1
    private int row; //row number equals coeffs.len

    //variables required for the interface
    private JTextField[][] jTextField;
    private JComboBox<String> choice;
    private javax.swing.JPanel appPanel;
    private javax.swing.JPanel appPanel2;
    private javax.swing.JComboBox<String> equComboBox;
    private javax.swing.JComboBox<String> coeffsComboBox;
    private javax.swing.JScrollPane jScrollPane;
    private JButton solve;
    private JButton changeButton;

    /**
     * initializes the gui
     */
    public Application() {
        super("Linear Solver Deluxe");
        prepareGUI();
    }

    /**
     * prepares gui
     * puts elements in the interface
     */
    private void prepareGUI() {
        appPanel = new javax.swing.JPanel();
        appPanel2 = new javax.swing.JPanel();
        Label baslik = new Label();
        Label equLabel = new Label();
        Label coeffsLabel = new Label();
        equComboBox = new javax.swing.JComboBox<>();
        coeffsComboBox = new javax.swing.JComboBox<>();
        jScrollPane = new javax.swing.JScrollPane();
        Button button_OK = new Button();
        solve = new JButton();
        changeButton = new JButton();

        //********************SET GUI ELEMENTS*************************//
        baslik.setFont(new java.awt.Font("Serif", Font.BOLD, 20));
        baslik.setText("Please enter the numbers.");

        equLabel.setFont(new java.awt.Font("Serif", Font.BOLD, 15));
        equLabel.setText("Number of equation: ");

        coeffsLabel.setFont(new java.awt.Font("Serif", Font.BOLD, 15));
        coeffsLabel.setText("Number of coefficients:  ");

        setComboBox(equComboBox);
        setComboBox(coeffsComboBox);

        choice = new JComboBox(new String[] {"Gaussian Elimination","Matrix Inversion"});
        choice.setSize(250, 40);
        choice.setVisible(true);

        button_OK.setFont(new java.awt.Font("Serif", Font.BOLD, 15)); 
        button_OK.setLabel("Ok");
        button_OK.addActionListener(this::button_OKActionPerformed);

        appPanel2.setVisible(false);
        jScrollPane.setVisible(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        //*************************SET FIRST PANEL***********************************//
        javax.swing.GroupLayout appPanelLayout = new javax.swing.GroupLayout(appPanel);
        appPanel.setLayout(appPanelLayout);
        appPanelLayout.setHorizontalGroup(
                appPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(appPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(appPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(appPanelLayout.createSequentialGroup()
                                                .addGroup(appPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(equLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(coeffsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(100, 100, 100)
                                                .addGroup(appPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(equComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(coeffsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(baslik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        //.addGap(35, 35, 35)
                                        .addGroup(appPanelLayout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addComponent(choice, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(9, 9, 9)
                                                .addComponent(button_OK, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(296, Short.MAX_VALUE))
        );
        appPanelLayout.setVerticalGroup(
                appPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(appPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(baslik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addGroup(appPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(equLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(appPanelLayout.createSequentialGroup()
                                                .addComponent(equComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20)
                                                .addGroup(appPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(coeffsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(coeffsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))

                                .addGroup(appPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(100, 100, 100)
                                .addComponent(choice, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(100, 100, 100)
                                        .addComponent(button_OK, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(354, Short.MAX_VALUE))
        );

        //******************************SET SECOND PANEL***********************************//
        appPanel2.setPreferredSize(new java.awt.Dimension(2000, 600));
        jScrollPane.setViewportView(appPanel2);

        javax.swing.GroupLayout appPanel2Layout = new javax.swing.GroupLayout(appPanel2);
        appPanel2.setLayout(appPanel2Layout);
        appPanel2Layout.setHorizontalGroup(
                appPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 200, Short.MAX_VALUE)
        );
        appPanel2Layout.setVerticalGroup(
                appPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 600, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(appPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(appPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(88, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane, javax.swing.GroupLayout.Alignment.TRAILING))
        );

        pack();
    }

    private void setComboBox(JComboBox<String> coeffsComboBox) {
        coeffsComboBox.setFont(new Font("Serif", Font.BOLD, 15));
        coeffsComboBox.setModel(new DefaultComboBoxModel<>(new String[] {"2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"}));
        coeffsComboBox.setMaximumRowCount(15);
    }

    /**
     * when click the OK button, it makes the first panel invisible and the second panel visible
     * @param evt event
     */
    private void button_OKActionPerformed(java.awt.event.ActionEvent evt) {
        int eqNum =Integer.parseInt((String) Objects.requireNonNull(equComboBox.getSelectedItem()));
        int coeffNum =Integer.parseInt((String) Objects.requireNonNull(coeffsComboBox.getSelectedItem()));

        row = eqNum;
        column = coeffNum + 1;

        if (eqNum != coeffNum) {
            JOptionPane.showMessageDialog(null, "In this application, the number of equation and the number of unknown must be equal.", "Wrong Inputs!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        coeffs = new double[row][column-1];
        solution = new double[row];

        appPanel.setVisible(false);
        appPanel2.setVisible(true);
        jScrollPane.setVisible(true);
        jTextField = new JTextField[row][column];

        this.setResizable(true); //buyuk num girebilir

        for (int i = 0; i < row; ++i)
            jTextField[i] = new JTextField[column];
        for (int i = 0; i < row; ++i)
            for (int j = 0; j < column; ++j) {
                JLabel label = new JLabel();
                label.setVisible(true);
                label.setSize(50, 30);
                
                jTextField[i][j] = new JTextField();
                jTextField[i][j].setSize(new Dimension(50, 30));
                jTextField[i][j].setVisible(true);

                if (j == column - 2)
                    label.setText("x" + (j+1) + "       =");
                else if (j != column - 1)
                    label.setText("x" + (j+1) + "       +");

                label.setLocation(100*j + 50, 30*i);
                jTextField[i][j].setLocation(100*j, 30*i);

                appPanel2.add(jTextField[i][j]);
                appPanel2.add(label);
            }

        solve.addActionListener(this::solveActionPerformed);
        solve.setVisible(true);
        solve.setSize(90,40);
        solve.setFont(new java.awt.Font("Serif", Font.BOLD, 20));
        solve.setText("Solve");
        solve.setLocation(200,40*row);

        appPanel2.add(solve);
    }

    /**
     * when click the solve button, it writes the solution
     * if the changeButton button is clicked, it returns to the beginning for repeating the calculations
     * @param evt event
     */
    private void solveActionPerformed(java.awt.event.ActionEvent evt) {
        LinearSolver linearSolver;
        double[] answer;

        try{
            for (int i = 0; i < row; ++i) {
                for (int j = 0; j < column; ++j) {
                    if (jTextField[i][j].getText().equals("") || jTextField[i][j].getText() == null) {
                        JOptionPane.showMessageDialog(null, "Please enter the all coefficients.", "Wrong Inputs!", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }
            }

            for (int i = 0; i < row; ++i) {
                for (int j = 0; j < column-1; ++j) 
                    coeffs[i][j] = Double.parseDouble(jTextField[i][j].getText());
                solution[i] = Double.parseDouble(jTextField[i][column-1].getText());
            }

            if (Objects.equals(choice.getSelectedItem(), "Gaussian Elimination"))
                linearSolver = new LinearSolver(new GaussianElimination(coeffs, solution));
            else
                linearSolver = new LinearSolver(new MatrixInversion(coeffs, solution));

            answer = linearSolver.solve();

            appPanel2.removeAll();
            appPanel2.setVisible(false);

            changeButton.setSize(200,50);
            changeButton.setVisible(true);
            changeButton.setText("Change Method");
            changeButton.setFont(new java.awt.Font("Serif", Font.BOLD, 20));
            changeButton.setLocation(300 ,50);

            changeButton.addActionListener(ae -> {
                appPanel2.removeAll();
                jScrollPane.setVisible(false);
                appPanel2.setVisible(false);
                appPanel.setVisible(true);

                for (int i = 0; i < row; ++i) {
                    for (int j = 0; j < column; ++j) {
                        jTextField[i][j].setText("");
                    }
                }
            });

            JLabel result = new JLabel();
            result.setText("Solution");
            result.setFont(new java.awt.Font("Serif", Font.BOLD, 22));
            result.setSize(250,50);
            result.setLocation(30,30);
            
            for (int i = 0; i < row; ++i) {
                JLabel label = new JLabel();
                label.setText(("x" + (i+1) + "  =  " + answer[i]));
                label.setVisible(true);
                label.setSize(250, 30);
                label.setFont(new java.awt.Font("Serif", Font.BOLD, 18));
                label.setLocation(30, (i+3)*label.getHeight());
                appPanel2.add(label);
            }

            appPanel2.add(changeButton);
            appPanel2.add(result);
            appPanel2.setVisible(true);
            
            jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        }catch(ArithmeticException e) {
            JOptionPane.showMessageDialog(null, "There is no solution for this equation", "No solution!", JOptionPane.ERROR_MESSAGE);
            solve.setEnabled(true);
        }catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter only number.", "Wrong Input!!", JOptionPane.WARNING_MESSAGE);
            solve.setEnabled(true);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something went wrong.", "Error!", JOptionPane.ERROR_MESSAGE);
            solve.setEnabled(true);
        }
    }

    /**
     * runs gui and create interface
     * @param args arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new Application().setVisible(true));
    }
    
}


