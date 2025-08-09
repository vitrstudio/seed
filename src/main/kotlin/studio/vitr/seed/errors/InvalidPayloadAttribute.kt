package studio.vitr.seed.errors

class InvalidPayloadAttribute(attributeName: String, objectName: String): Error("invalid $attributeName in $objectName")