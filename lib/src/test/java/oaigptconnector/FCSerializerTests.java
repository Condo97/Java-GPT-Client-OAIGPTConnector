package oaigptconnector;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oaigptconnector.model.OAIFunctionCallSerializer;
import com.oaigptconnector.model.OAISerializerException;
import com.oaigptconnector.model.fcobjects.ifcbase.FCBase;
import oaigptconnector.testobjects.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class FCSerializerTests {

    @Test
    @DisplayName("Serialize Basic Object")
    void testSerializeBasicObject() {
        try {
            FCBase base = OAIFunctionCallSerializer.objectify(SimpleStringSerializable.class);

            System.out.println(new ObjectMapper().writeValueAsString(base));
        } catch (OAISerializerException e) {
            throw new RuntimeException(e);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonGenerationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Serialize Multi Type Object")
    void testSerializeMultiTypeObject() {
        try {
            FCBase base = OAIFunctionCallSerializer.objectify(MultiTypeSerializable.class);

            System.out.println(new ObjectMapper().writeValueAsString(base));
        } catch (OAISerializerException e) {
            throw new RuntimeException(e);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonGenerationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Serialize Complex Type Object")
    void testSerializeComplexTypeObject() {
        try {
            FCBase base = OAIFunctionCallSerializer.objectify(ComplexTypeSerializable.class);

            System.out.println(new ObjectMapper().writeValueAsString(base));
        } catch (OAISerializerException e) {
            throw new RuntimeException(e);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonGenerationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Serialize Missing Function Call Annotation Object")
    void testSerializeMissingFunctionCallAnnotationObject() {
        try {
            FCBase base = OAIFunctionCallSerializer.objectify(MissingFunctionCallAnnotation.class);

            System.out.println(new ObjectMapper().writeValueAsString(base));
        } catch (OAISerializerException e) {
            System.out.println("Expected output");
            e.printStackTrace();

        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonGenerationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Serialize Missing FCParameter Object")
    void testSerializeMissingFCParameterObject() {
        try {
            FCBase base = OAIFunctionCallSerializer.objectify(MissingFCParameterAnnotation.class);

            System.out.println(new ObjectMapper().writeValueAsString(base));
        } catch (OAISerializerException e) {
            System.out.println("Expected output");
            e.printStackTrace();

        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonGenerationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Serialize Non Serializable Parameter Object")
    void testSerializeNonSerializableParameterObject() {
        try {
            FCBase base = OAIFunctionCallSerializer.objectify(NonSerializableParameter.class);

            System.out.println(new ObjectMapper().writeValueAsString(base));
        } catch (OAISerializerException e) {
            System.out.println("Expected output");
            e.printStackTrace();

        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonGenerationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Serialize Non Serializable Parameter With Serializable Parameter Object")
    void testSerializeNonSerializableParameterWithSerializableParameterObject() {
        try {
            FCBase base = OAIFunctionCallSerializer.objectify(NonSerializableParameterWithSerializableParameterObject.class);

            System.out.println(new ObjectMapper().writeValueAsString(base));
        } catch (OAISerializerException e) {
            System.out.println("Expected output");
            e.printStackTrace();

        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonGenerationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Serialize Non Annotated Non Serializable Types With Annotated and Non Annotated Serializable Parameter Object")
    void testSerializeNonAnnotatedNonSerializableTypesWithAnnotatedAndNonAnnotatedSerializableParameterObject() {
        try {
            FCBase base = OAIFunctionCallSerializer.objectify(NonAnnotatedNonSerializableTypesWithAnnotatedAndNonAnnotatedSerializableParameter.class);

            System.out.println(new ObjectMapper().writeValueAsString(base));
        } catch (OAISerializerException e) {
            throw new RuntimeException(e);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonGenerationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
