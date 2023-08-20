package oaigptconnector.serializer.testobjects;

import com.oaigptconnector.model.FCParameter;
import com.oaigptconnector.model.FunctionCall;

import java.util.List;

@FunctionCall(name = "Complex_Type_Serializable", functionDescription = "Function Description :)", baseObjectDescription = "Base Object Description :)")
public class ComplexTypeSerializable {

    public class FirstInnerClass {

        public class SecondInnerClass {

            @FCParameter()
            private String secondInnerString;

            @FCParameter(description = "the second inner Integer description")
            private Integer secondInnerInteger;

            public SecondInnerClass() {

            }

            public SecondInnerClass(String secondInnerString, Integer secondInnerInteger) {
                this.secondInnerString = secondInnerString;
                this.secondInnerInteger = secondInnerInteger;
            }

            public String getSecondInnerString() {
                return secondInnerString;
            }

            public Integer getSecondInnerInteger() {
                return secondInnerInteger;
            }

        }

        @FCParameter()
        private List<SecondInnerClass> firstInnerSecondInnerClassList;

        @FCParameter()
        private SecondInnerClass firstInnerSecondInnerClass;

        @FCParameter()
        private String firstInnerString;

        public FirstInnerClass() {

        }

        public FirstInnerClass(List<SecondInnerClass> firstInnerSecondInnerClassList, SecondInnerClass firstInnerSecondInnerClass, String firstInnerString) {
            this.firstInnerSecondInnerClassList = firstInnerSecondInnerClassList;
            this.firstInnerSecondInnerClass = firstInnerSecondInnerClass;
            this.firstInnerString = firstInnerString;
        }

        public List<SecondInnerClass> getFirstInnerSecondInnerClassList() {
            return firstInnerSecondInnerClassList;
        }

        public SecondInnerClass getFirstInnerSecondInnerClass() {
            return firstInnerSecondInnerClass;
        }

        public String getFirstInnerString() {
            return firstInnerString;
        }

    }

    @FCParameter()
    private List<FirstInnerClass> baseFirstInnerClassList;

    @FCParameter()
    private FirstInnerClass baseFirstInnerClass;

    @FCParameter()
    private FirstInnerClass.SecondInnerClass baseSecondInnerClass;

    public ComplexTypeSerializable() {

    }

    public ComplexTypeSerializable(List<FirstInnerClass> baseFirstInnerClassList, FirstInnerClass baseFirstInnerClass, FirstInnerClass.SecondInnerClass baseSecondInnerClass) {
        this.baseFirstInnerClassList = baseFirstInnerClassList;
        this.baseFirstInnerClass = baseFirstInnerClass;
        this.baseSecondInnerClass = baseSecondInnerClass;
    }

    public List<FirstInnerClass> getBaseFirstInnerClassList() {
        return baseFirstInnerClassList;
    }

    public FirstInnerClass getBaseFirstInnerClass() {
        return baseFirstInnerClass;
    }

    public FirstInnerClass.SecondInnerClass getBaseSecondInnerClass() {
        return baseSecondInnerClass;
    }

}
