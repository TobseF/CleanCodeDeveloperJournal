import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@polymer/iron-icon/iron-icon';

class ProgressBar extends PolymerElement {

    static get template() {
        return html`<style>
    .progressbar {
        width: 100%;
    }

    .progressbar-progress {
        border-radius: 5px;
        display: flex;
        justify-content: space-between;
        position: relative;
        padding: 2px 10px;
    }

    .start {
        display: flex;
    }

    .label {
        margin-right: 15px;
    }
</style>

<div class="progressbar">
    <div class="progressbar-progress" style="background: linear-gradient(to right, #24D1FF [[percent]]%, #1B8B9E 0%);">
        <div class="start">
            <div class="label">[[label]]</div>
            <div class="value">[[value]]</div>
        </div>
        <div>[[description]]</div>
    </div>`;
    }

    static get is() {
        return 'progress-bar';
    }
}

customElements.define(ProgressBar.is, ProgressBar);