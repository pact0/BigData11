package project

import project.datawriter.Datawriter
import org.apache.spark.sql.SparkSession
import project.datareader.Datareader

object SparkProject {
  val spark: SparkSession = SparkSession.builder.master("local[4]")
    .appName("App")
    .getOrCreate();

  def main(args: Array[String]): Unit = {
    val actorsDf = Datareader.readActors("src\\Data\\actors.csv");
    val namesDf = Datareader.readNames("src\\Data\\names.csv");
    val actorsTrans = actorsDf.filter(row => Transform.Trans.hasAssignedJob(row));
    val namesTrans = namesDf.filter(row => Transform.Trans.hasKids(row));
    actorsTrans.show();
    namesTrans.show();
    Datawriter.writedf(actorsTrans.toDF(), "output.csv");
  }

}
