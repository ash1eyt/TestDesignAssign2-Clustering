package com.ontariotechu.sofe3980U;             //Importing libraries and packages
import net.sf.javaml.clustering.*;
import net.sf.javaml.clustering.evaluation.*;
import java.io.File;

import net.sf.javaml.core.Dataset;
import net.sf.javaml.tools.data.FileHandler;

public class App {
    public static void main(String[] args) throws Exception {

        /*Loads and prints out the iris data set*/

        Dataset data = FileHandler.loadDataset(new File("ClusterAssign2/src/main/data/iris.data"), 4, ",");

        System.out.println("\nIris data set: ");

        System.out.println(data);

        Clusterer km1 = new KMeans(4);      //Creates new instances for KMeans with k=4, k=5, k=6, k=7 clusters
        Clusterer km2 = new KMeans(5);
        Clusterer km3 = new KMeans(6);
        Clusterer km4 = new KMeans(7);
        Clusterer dm = new DensityBasedSpatialClustering();  //Creates new instances for DBSC and FarthestFirst
        Clusterer ff = new FarthestFirst();

        /*Clusters the data*/

        Dataset[] clusters4 = km1.cluster(data);
        Dataset[] clusters5 = km2.cluster(data);
        Dataset[] clusters6 = km3.cluster(data);
        Dataset[] clusters7 = km4.cluster(data);
        Dataset[] clustersdb = dm.cluster(data);
        Dataset[] clustersff = ff.cluster(data);

        /*Creates new instances for evaluation such as the AIC score, BIC score, sum of squared errors, and HPS*/

        ClusterEvaluation aic = new AICScore();
        ClusterEvaluation bic = new BICScore();
        ClusterEvaluation sse = new SumOfSquaredErrors();
        ClusterEvaluation hps = new HybridPairwiseSimilarities();

        /*For k = 4 (KMeans)*/

        double aicScore4 = aic.score(clusters4);
        double bicScore4 = bic.score(clusters4);
        double sseScore4 = sse.score(clusters4);
        double hpsScore4 = hps.score(clusters4);

        /*For k = 5 (KMeans)*/

        double aicScore5 = aic.score(clusters5);
        double bicScore5 = bic.score(clusters5);
        double sseScore5 = sse.score(clusters5);
        double hpsScore5 = hps.score(clusters5);

        /*For k = 6 (KMeans)*/

        double aicScore6 = aic.score(clusters6);
        double bicScore6 = bic.score(clusters6);
        double sseScore6 = sse.score(clusters6);
        double hpsScore6 = hps.score(clusters6);

        /*For k = 7 (KMeans)*/

        double aicScore7 = aic.score(clusters7);
        double bicScore7 = bic.score(clusters7);
        double sseScore7 = sse.score(clusters7);
        double hpsScore7 = hps.score(clusters7);

        /*For the clusters using the DBSC algorithm*/

        double aicScoredb = aic.score(clustersdb);
        double bicScoredb = bic.score(clustersdb);
        double sseScoredb = sse.score(clustersdb);
        double hpsScoredb = hps.score(clustersdb);

        /*For the clusters using the Farthest First algorithm*/

        double aicScoreff = aic.score(clustersff);
        double bicScoreff = bic.score(clustersff);
        double sseScoreff = sse.score(clustersff);
        double hpsScoreff = hps.score(clustersff);

        System.out.println("\n");

        System.out.println("K-means clustering \n");

        System.out.println(" ------------------ 4 CLUSTERS ---------------------");     //Prints out cluster
        for (int i = 0; i < clusters4.length; i++){
            System.out.println("Cluster: " + (i+1));
            System.out.println(clusters4[i]);
        }

        System.out.println("\n");

        System.out.println(" ------------------ 5 CLUSTERS  ---------------------");    //Prints out cluster
        for (int i = 0; i < clusters5.length; i++){
            System.out.println("Cluster: " + (i+1));
            System.out.println(clusters5[i]);
        }

        System.out.println("\n");

        System.out.println("Results: ");                                    //Prints out evaluations for KMeans

        System.out.println("AIC score: " + aicScore4 + "\t" + aicScore5);
        System.out.println("BIC score: " + bicScore4 + "\t" + bicScore5);
        System.out.println("Sum of squared errors: " + sseScore4 + "\t" + sseScore5);
        System.out.println("Hybrid Pairwise Similarities for (k=4) cluster: " + hpsScore4);
        System.out.println("Hybrid Pairwise Similarities for (k=5) cluster : " + hpsScore5);

        System.out.println("\n");

        System.out.println(" ------------------ 6 CLUSTERS ---------------------");     //Prints out cluster
        for (int i = 0; i < clusters6.length; i++){
            System.out.println("Cluster: " + (i+1));
            System.out.println(clusters6[i]);
        }

        System.out.println("\n");

        System.out.println(" ------------------ 7 CLUSTERS  ---------------------");    //Prints out cluster
        for (int i = 0; i < clusters7.length; i++){
            System.out.println("Cluster: " + (i+1));
            System.out.println(clusters7[i]);
        }

        System.out.println("\n");

        System.out.println("Results: ");                                    //Prints out evaluations for KMeans

        System.out.println("AIC score: " + aicScore6 + "\t" + aicScore7);
        System.out.println("BIC score: " + bicScore6 + "\t" + bicScore7);
        System.out.println("Sum of squared errors: " + sseScore6 + "\t" + sseScore7);
        System.out.println("Hybrid Pairwise Similarities for (k=6) cluster: " + hpsScore6);
        System.out.println("Hybrid Pairwise Similarities for (k=7) cluster : " + hpsScore7);

        System.out.println("\n");

        System.out.println("Density-based Spatial Clustering \n");      //Prints out cluster and evaluation for DBSC

        System.out.println(" ------------------ 2 CLUSTERS ---------------------");

       for (int i = 0; i < clustersdb.length; i++){
          System.out.println("Cluster: " + (i+1));
          System.out.println(clustersdb[i]);
       }

        System.out.println("AIC score: " + aicScoredb);
        System.out.println("BIC score: " + bicScoredb);
        System.out.println("Sum of squared errors: " + sseScoredb);
        System.out.println("Hybrid Pairwise Similarities: " + hpsScoredb);

        System.out.println("\n");

        System.out.println("Farthest First Clustering \n");     //Prints out cluster and evaluation for FF Clustering
        System.out.println(" ------------------ 4 CLUSTERS ---------------------");

        for (int i = 0; i < clustersff.length; i++){
            System.out.println("Cluster: " + (i+1));
            System.out.println(clustersff[i]);
        }
     
        System.out.println("AIC score: " + aicScoreff);
        System.out.println("BIC score: " + bicScoreff);
        System.out.println("Sum of squared errors: " + sseScoreff);
        System.out.println("Hybrid Pairwise Similarities: " + hpsScoreff);

    }

}