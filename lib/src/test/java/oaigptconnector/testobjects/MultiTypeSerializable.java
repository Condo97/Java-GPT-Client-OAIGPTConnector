package oaigptconnector.testobjects;

import com.oaigptconnector.model.FCParameter;
import com.oaigptconnector.model.FunctionCall;

import java.util.List;

@FunctionCall(name = "Multi_Type_Serializable", functionDescription = "multi type serializable function description")
public class MultiTypeSerializable {

    public class InnerClassSerializable {

        @FCParameter(description = "Inner String type variable")
        private String innerString;

        @FCParameter(description = "Inner Boolean type variable")
        private Boolean innerBooleanType;

        @FCParameter(description = "Inner boolean type variable")
        private boolean innerBooleanPrimitiveType;

        @FCParameter(description = "Inner Integer type variable")
        private Integer innerInteger;

        @FCParameter(description = "Inner int type variable")
        private int innerInt;

        @FCParameter(description = "Inner List type variable")
        private List<String> stringListType;

        public InnerClassSerializable() {

        }

        public InnerClassSerializable(String innerString, Boolean innerBooleanType, boolean innerBooleanPrimitiveType, Integer innerInteger, int innerInt, List<String> stringListType) {
            this.innerString = innerString;
            this.innerBooleanType = innerBooleanType;
            this.innerBooleanPrimitiveType = innerBooleanPrimitiveType;
            this.innerInteger = innerInteger;
            this.innerInt = innerInt;
            this.stringListType = stringListType;
        }

        public String getInnerString() {
            return innerString;
        }

        public Boolean getInnerBooleanType() {
            return innerBooleanType;
        }

        public boolean isInnerBooleanPrimitiveType() {
            return innerBooleanPrimitiveType;
        }

        public Integer getInnerInteger() {
            return innerInteger;
        }

        public int getInnerInt() {
            return innerInt;
        }

        public List<String> getStringListType() {
            return stringListType;
        }

    }

    @FCParameter(description = "String type variable")
    private String stringType;

    @FCParameter(description = "Boolean type variable")
    private Boolean booleanType;

    @FCParameter(description = "boolean type variable")
    private boolean booleanPrimitiveType;

    @FCParameter(description = "Integer type variable")
    private Integer integerType;

    @FCParameter(description = "int type variable")
    private int intType;

    @FCParameter(description = "String list type variable")
    private List<String> stringListType;

    @FCParameter(description = "Integer list type variable")
    private List<Integer> integerListType;

    @FCParameter(description = "Sub-object type variable")
    private InnerClassSerializable subObjectType;

    public MultiTypeSerializable() {

    }

    public MultiTypeSerializable(String stringType, Boolean booleanType, boolean booleanPrimitiveType, Integer integerType, int intType, List<String> stringListType, List<Integer> integerListType, InnerClassSerializable subObjectType) {
        this.stringType = stringType;
        this.booleanType = booleanType;
        this.booleanPrimitiveType = booleanPrimitiveType;
        this.integerType = integerType;
        this.intType = intType;
        this.stringListType = stringListType;
        this.integerListType = integerListType;
        this.subObjectType = subObjectType;
    }

    public String getStringType() {
        return stringType;
    }

    public Boolean getBooleanType() {
        return booleanType;
    }

    public boolean isBooleanPrimitiveType() {
        return booleanPrimitiveType;
    }

    public Integer getIntegerType() {
        return integerType;
    }

    public int getIntType() {
        return intType;
    }

    public List<String> getStringListType() {
        return stringListType;
    }

    public List<Integer> getIntegerListType() {
        return integerListType;
    }

    public InnerClassSerializable getSubObjectType() {
        return subObjectType;
    }

}
