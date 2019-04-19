package com.generator;

public class SystemGenerator {
    public static void main(String[] args) {
        CodeGenerator codeGenerator = new CodeGenerator();

//        codeGenerator.generatorCode("system", "sys","SYS_TASK", "SYS_PERMISSION", "SYS_PARAM", "SYS_PERMISSION", "SYS_ROLE", "SYS_ROLE_PERMISSION", "SYS_USER", "SYS_USER_ROLE");
        codeGenerator.generatorCode("business.ccdi", "CCDI", "^CCDI.*");
    }
}
