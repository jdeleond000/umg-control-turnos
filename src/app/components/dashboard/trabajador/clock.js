class Clock {
  constructor(element) {
    this._element = element;
    let html = '';
    for (let i = 0; i < 6; i++) {
      html += '<span>&nbsp;</span>';
    }
    this._element.innerHTML = html;
    this._slots = this._element.getElementsByTagName('span');
    this._tick();
  }

  _tick() {
    const time = new Date();
    this._update(this._pad(time.getHours()) + this._pad(time.getMinutes()) + this._pad(time.getSeconds()));
    setTimeout(() => {
      this._tick();
    }, 1000);
  }

  _pad(value) {
    return ('0' + value).slice(-2);
  }

  _update(timeString) {
    for (let i = 0; i < this._slots.length; i++) {
      const value = timeString.charAt(i);
      const slot = this._slots[i];
      const now = slot.dataset.now;

      if (!now) {
        slot.dataset.now = value;
        slot.dataset.old = value;
        continue;
      }

      if (now !== value) {
        this._flip(slot, value);
      }
    }
  }

  _flip(slot, value) {
    slot.classList.remove('flip');
    slot.dataset.old = slot.dataset.now || '';
    slot.dataset.now = value;
    slot.offsetLeft; // force reflow
    slot.classList.add('flip');
  }
}

export default Clock;
