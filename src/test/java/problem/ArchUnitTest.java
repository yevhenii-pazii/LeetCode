package problem;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.domain.JavaModifier;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

class ArchUnitTest {

    @Test
    void problemClassesMustBePackagePrivate() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("problem");

        ArchRule rule = classes().should().notHaveModifier(JavaModifier.PUBLIC);

        rule.check(importedClasses);
    }
}
