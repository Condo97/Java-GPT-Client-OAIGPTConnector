package oaigptconnector.serializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oaigptconnector.model.FCJSONSchemaSerializer;
import com.oaigptconnector.model.OAISerializerException;
import com.oaigptconnector.model.jsonschema.ifcbase.FCBase;
import oaigptconnector.serializer.testobjects.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class FCSerializerTests {

    @Test
    @DisplayName("Serialize Basic Object")
    void testSerializeBasicObject() {
        try {
            FCBase base = FCJSONSchemaSerializer.objectify(SimpleStringSerializable.class);

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
            FCBase base = FCJSONSchemaSerializer.objectify(MultiTypeSerializable.class);

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
            FCBase base = FCJSONSchemaSerializer.objectify(ComplexTypeSerializable.class);

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
            FCBase base = FCJSONSchemaSerializer.objectify(MissingFunctionCallAnnotation.class);

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
            FCBase base = FCJSONSchemaSerializer.objectify(MissingFCParameterAnnotation.class);

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
            FCBase base = FCJSONSchemaSerializer.objectify(NonSerializableParameter.class);

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
            FCBase base = FCJSONSchemaSerializer.objectify(NonSerializableParameterWithSerializableParameterObject.class);

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
            FCBase base = FCJSONSchemaSerializer.objectify(NonAnnotatedNonSerializableTypesWithAnnotatedAndNonAnnotatedSerializableParameter.class);

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
