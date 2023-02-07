from pydantic import (
    BaseSettings,
    PostgresDsn,
)
import logging


def config_logger():
    file_handler = logging.FileHandler("logs.log")
    file_handler.setLevel(logging.INFO)
    fileformat = logging.Formatter("%(asctime)s:%(levelname)s:%(message)s", datefmt="%H:%M:%S")
    file_handler.setFormatter(fileformat)

    stream = logging.StreamHandler()
    stream.setLevel(logging.INFO)
    streamformat = logging.Formatter("%(asctime)s:%(levelname)s:%(message)s")
    stream.setFormatter(streamformat)
    logging.basicConfig(level=logging.DEBUG , handlers=[file_handler, stream])


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
