package studio.vitr.seed.errors

class ExpiredToken(tokenType: String) : Error("$tokenType is expired")