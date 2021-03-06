package com.boraji.tutorial.jfreechart.bubblechart;

import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.BubbleXYItemLabelGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBubbleRenderer;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYZDataset;

/**
 * @author imssbora
 */
public class BubbleChartExample extends JFrame {

  private static final long serialVersionUID = 1L;

  /**
   * 
   */
  public BubbleChartExample(String title) {
    super(title);

    // Create dataset
    XYZDataset dataset = createDataset();

    // Create chart
    JFreeChart chart = ChartFactory.createBubbleChart(
        "Country(Cars, Buses, Trucks)", 
        "X-Values", 
        "Y-Values", dataset);

    
    // Set range for X-Axis
    XYPlot plot = chart.getXYPlot();
    NumberAxis domain = (NumberAxis) plot.getDomainAxis();
    domain.setRange(0, 100);

    // Set range for Y-Axis
    NumberAxis range = (NumberAxis) plot.getRangeAxis();
    range.setRange(0, 100);
    
    //Format label
    XYBubbleRenderer renderer=(XYBubbleRenderer)plot.getRenderer();
    BubbleXYItemLabelGenerator generator=new BubbleXYItemLabelGenerator(
        " {0}:({1},{2},{3}) ",new DecimalFormat("0"),
        new DecimalFormat("0"),
        new DecimalFormat("0"));
    renderer.setBaseItemLabelGenerator(generator);
    renderer.setBaseItemLabelsVisible(true);
    
    // Create Panel
    ChartPanel panel = new ChartPanel(chart);
    setContentPane(panel);
  }

  /**
   * @return
   */
  private XYZDataset createDataset() {
    DefaultXYZDataset dataset = new DefaultXYZDataset();

    dataset.addSeries("INDIA", new double[][] { 
      { 40 }, // X-Value 
      { 65 }, // Y-Value 
      { 70 }  // Z-Value 
     });
    dataset.addSeries("USA", new double[][] { { 30 }, { 20 }, { 50 } });
    dataset.addSeries("CHINA", new double[][] { { 80 }, { 50 }, { 80 } });
    dataset.addSeries("JAPAN", new double[][] { { 11 }, { 50 }, { 20 } });

    return dataset;
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      BubbleChartExample example = new BubbleChartExample("Bubble Chart Example | BORAJI.COM");
      example.setSize(800, 400);
      example.setLocationRelativeTo(null);
      example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      example.setVisible(true);
    });
  }
}