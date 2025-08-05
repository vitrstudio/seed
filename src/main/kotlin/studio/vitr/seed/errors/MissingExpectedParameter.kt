package studio.vitr.seed.errors

class MissingExpectedParameter(param: String): Error("missing expected $param")