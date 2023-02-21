import logging
from fastapi import APIRouter, Depends, HTTPException
from sqlalchemy.orm import Session
from ..dependencies import get_db
from .service import get_class_schedule
from .exceptions import NoScheduleEventsArePresent

router = APIRouter(
    prefix='/schedule',
)


@router.get('/class/{class_id}')
def class_schedule_by_week(class_id: int, db: Session = Depends(get_db)):
    try:
        schedule: dict = get_class_schedule(db, class_id)
    except NoScheduleEventsArePresent as e:
        logging.error(e)
        raise HTTPException(500, 'Schedule for this class is not found')
    return schedule
