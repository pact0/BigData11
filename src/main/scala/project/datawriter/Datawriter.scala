package project.datawriter

import org.apache.spark.sql.DataFrame

object Datawriter {
  def writedf(dt:DataFrame,path: String): Unit = {
    dt.write.format("csv").save(path);
  }
}