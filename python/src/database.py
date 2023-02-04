from sqlalchemy import create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import sessionmaker
from .config import instantiate_settings

SQLALCHEMY_DATABASE_URL = instantiate_settings().SCHOOL_DB_URL

engine = create_engine(SQLALCHEMY_DATABASE_URL)

# Make sure to close after opening a connection
SessionLocal = sessionmaker(autocommit=False, autoflush=False, bind=engine)

Base = declarative_base()
