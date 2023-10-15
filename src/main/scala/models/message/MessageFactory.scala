package models.message

import models.Diary

trait IMessageFactory {
  def createByDiary(diary: Diary): String
}
case class MessageFactory() extends IMessageFactory {
  def createByDiary(diary: Diary): String = {
    s"日付: ${diary.selectedDate}\n開始時刻: ${diary.startTime}\n終了時刻: ${diary.endTime}\nメモ: ${diary.memo}"
  }
}
