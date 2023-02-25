# coding: utf-8| Generated with sqlacodegen
from sqlalchemy import BigInteger, CHAR, Column, Date, ForeignKey, Integer, String, Time, text
from sqlalchemy.orm import relationship
from sqlalchemy.ext.declarative import declarative_base

Base = declarative_base()
metadata = Base.metadata


class TeacherSubject(Base):
    __tablename__ = 'teacher_subjects'
    __table_args__ = {'schema': 'public'}

    id = Column(BigInteger, primary_key=True, server_default=text("nextval('\"public\".teacher_subjects_id_seq'::regclass)"))
    teacher_id = Column(ForeignKey('public.teachers.id'), nullable=False)
    class_id = Column(ForeignKey('public.classes.id'), nullable=False)
    subject_id = Column(ForeignKey('public.subjects.id'), nullable=False)

    _class = relationship('_Class')
    subject = relationship('Subject')
    teacher = relationship('Teacher')


class EventType(Base):
    __tablename__ = 'event_types'
    __table_args__ = {'schema': 'public'}

    id = Column(BigInteger, primary_key=True, server_default=text("nextval('\"public\".event_types_id_seq'::regclass)"))
    name = Column(String(100), nullable=False)


class Subject(Base):
    __tablename__ = 'subjects'
    __table_args__ = {'schema': 'public'}

    id = Column(BigInteger, primary_key=True, server_default=text("nextval('\"public\".subjects_id_seq'::regclass)"))
    name = Column(String(100), nullable=False)

    schedule = relationship('Schedule', secondary=TeacherSubject, back_populates='subject')


class Teacher(Base):
    __tablename__ = 'teachers'
    __table_args__ = {'schema': 'public'}

    id = Column(BigInteger, primary_key=True, server_default=text("nextval('\"public\".teachers_id_seq'::regclass)"))
    first_name = Column(String(100), nullable=False)
    surname = Column(String(100), nullable=False)
    patronymic = Column(String(100), nullable=False)
    phone = Column(BigInteger, nullable=False)
    email = Column(String(100))

    schedule = relationship('Schedule', secondary=TeacherSubject, back_populates='teacher')


class _Class(Base):
    __tablename__ = 'classes'
    __table_args__ = {'schema': 'public'}

    id = Column(BigInteger, primary_key=True, server_default=text("nextval('\"public\".classes_id_seq'::regclass)"))
    name_letter = Column(CHAR(1), nullable=False)
    name_number = Column(Integer, nullable=False)
    head_teacher_id = Column(ForeignKey('public.teachers.id'), nullable=False, unique=True)

    head_teacher = relationship('Teacher', uselist=False)
    schedule = relationship('Schedule', secondary=TeacherSubject, back_populates='_class')


class Student(Base):
    __tablename__ = 'students'
    __table_args__ = {'schema': 'public'}

    id = Column(BigInteger, primary_key=True, server_default=text("nextval('\"public\".students_id_seq'::regclass)"))
    first_name = Column(String(100), nullable=False)
    surname = Column(String(100), nullable=False)
    patronymic = Column(String(100), nullable=False)
    phone = Column(BigInteger, nullable=False)
    email = Column(String(100))
    class_id = Column(ForeignKey('public.classes.id'), nullable=False)

    _class = relationship('_Class')


class Homework(Base):
    __tablename__ = 'homeworks'
    __table_args__ = {'schema': 'public'}

    id = Column(BigInteger, primary_key=True, server_default=text("nextval('\"public\".homeworks_id_seq'::regclass)"))
    teacher_subject_id = Column(ForeignKey('public.teacher_subjects.id'), nullable=False)
    description = Column(String(300), nullable=False)
    deadline = Column(Date)

    teacher_subject = relationship('TeacherSubject')


class Journal(Base):
    __tablename__ = 'journals'
    __table_args__ = {'schema': 'public'}

    id = Column(BigInteger, primary_key=True, server_default=text("nextval('\"public\".journals_id_seq'::regclass)"))
    teacher_subject_id = Column(ForeignKey('public.teacher_subjects.id'), nullable=False)

    teacher_subject = relationship('TeacherSubject')


class Schedule(Base):
    __tablename__ = 'schedules'
    __table_args__ = {'schema': 'public'}

    id = Column(BigInteger, primary_key=True, server_default=text("nextval('\"public\".schedules_id_seq'::regclass)"))
    teacher_subject_id = Column(ForeignKey('public.teacher_subjects.id'), nullable=False)
    start_time = Column(Time, nullable=False)
    weekday = Column(String(20), nullable=False)
    room_name = Column(String(10))

    teacher_subject = relationship('TeacherSubject')
    teacher = relationship('Teacher', secondary=TeacherSubject, back_populates='schedule')
    _class = relationship('_Class', secondary=TeacherSubject, back_populates='schedule')
    subject = relationship('Subject', secondary=TeacherSubject, back_populates='schedule')


class Event(Base):
    __tablename__ = 'events'
    __table_args__ = {'schema': 'public'}

    id = Column(BigInteger, primary_key=True, server_default=text("nextval('\"public\".events_id_seq'::regclass)"))
    journal_id = Column(ForeignKey('public.journals.id'), nullable=False)
    type = Column(ForeignKey('public.event_types.id'), nullable=False)
    creation_date = Column(Date, nullable=False)
    description = Column(String(300))

    journal = relationship('Journal')
    event_type = relationship('EventType')


class Grade(Base):
    __tablename__ = 'grades'
    __table_args__ = {'schema': 'public'}

    id = Column(BigInteger, primary_key=True, server_default=text("nextval('\"public\".grades_id_seq'::regclass)"))
    grade = Column(Integer, nullable=False)
    student_id = Column(ForeignKey('public.students.id'), nullable=False)
    event_id = Column(ForeignKey('public.events.id'), nullable=False)

    event = relationship('Event')
    student = relationship('Student')

