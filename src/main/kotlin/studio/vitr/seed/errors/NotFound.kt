package studio.vitr.seed.errors

class NotFound(entity: String, id: String): Error("$entity $id not found")