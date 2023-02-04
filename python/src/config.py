from pydantic import (
    BaseSettings,
    PostgresDsn,
)


class Settings(BaseSettings):
    POSTGRES_DSN: PostgresDsn
    SCHOOL_DB_URL: PostgresDsn
    DOMAIN: str
    PORT: str

    class Config:
        case_sensitive = False
        env_file = '.env'
        secrets_dir = "../"
        env_file_encoding = 'utf-8'


# Key word is 'instantiate', because every time this function is called, it reads from file. Caching is advised
def instantiate_settings() -> Settings:
    return Settings()
