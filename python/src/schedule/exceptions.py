class NoScheduleEventsArePresent(Exception):
    def __init__(self, message: str = 'Schedule events are not present in the list', errors=list()):
        super().__init__(message)
        self.errors = errors
