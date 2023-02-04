from fastapi import APIRouter

router = APIRouter(
    prefix='/admin',
)


@router.get('/')
def test():
    return {}
