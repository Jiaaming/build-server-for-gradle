package ch.epfl.scala.bsp4j.extended;

public class Output {
    private String outputType;
    private String outputBytes;

    public Output() {}

    public Output(String outputType, String outputBytes) {
      this.outputType = outputType;
      this.outputBytes = outputBytes;
    }

    public String getOutputType() {
      return outputType;
    }

    public void setOutputType(String outputType) {
      this.outputType = outputType;
    }

    public String getOutputBytes() {
      return outputBytes;
    }

    public void setOutputBytes(String outputBytes) {
      this.outputBytes = outputBytes;
    }
  }
