package project.datareader

import org.apache.spark.sql.{Dataset, SparkSession}
import project.Case.Names
import project.Case.Actors

object Datareader {

  def readNames( path: String): Dataset[Names] = {
    val spark = SparkSession.builder.master("local[4]")
      .appName("App")
      .getOrCreate();
    import spark.implicits._;
    return spark.read.format("csv").option("header",true).option("delimiter", ";").load(path).as[Names]
  }
  def readActors(path: String): Dataset[Actors] = {
    val spark = SparkSession.builder.master("local[4]")
      .appName("App")
      .getOrCreate()
    import spark.implicits._;
    return spark.read.format("csv").option("header",true).option("delimiter", ";").load(path).as[Actors]
  }
}